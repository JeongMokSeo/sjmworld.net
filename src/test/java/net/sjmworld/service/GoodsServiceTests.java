package net.sjmworld.service;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.sjmworld.domain.GoodsVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GoodsServiceTests {
	@Setter @Autowired
	private GoodsService service;
//	private String uploadFolder = "c:/musinsa";
	private String uploadFolder = "c:/kream";
	
	@Test
	public void testExist() {
		assertNotNull(service);		
	}
	
	@Test
	public void Crawl() throws MalformedURLException, IOException {
		
		for (int j =1; j <= 1 ; j++)  {
			//String url = "https://www.naver.com/";
			System.out.println(j + ": 페이지" );
			String url = "https://search.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=&subCategory=&leafCategory=&price=&golf=false&newProduct=false&exclusive=false&discount=false&soldOut=false&viewType=small&priceMin=&priceMax=&page=" + j;
			Document doc  = Jsoup.parse(new URL(url),20000);
			saveHTML(j, doc.toString());
			
			
			
			//System.out.println(doc);
			Element outUl = doc.selectFirst("#goodsRankList");
			Elements lis = outUl.select(".li_box");
			
			
			for (int i = 0; i < lis.size(); i++) {
				//System.out.println(lis.get(i).attr("data-goods-no"));
				Element li = lis.get(i);
				
				String pk = li.attr("data-goods-no");
				String link = li.selectFirst(".img-block").attr("href");
				
				//세부페이지의 링크
				// 섬네일
				String thumbLink = li.selectFirst("img.lazyload.lazy").attr("data-original");
				
				System.out.println(thumbLink);
				
				fileDownload(pk, thumbLink);
			}			
		}		
	}
	
	@Test
	public void testCrawlDetail() throws MalformedURLException, IOException {

		File file = new File(uploadFolder);
		Stream.of(file.listFiles(File::isDirectory)).sorted().forEach(dir->{
			//log.info(dir.getName());

			
			
			String pk = dir.getName(); //"2081554";
			if(pk.substring(0,1).equals("9")) {
				log.info("start:: " + dir.getName());
				try{
					String url = String.format("https://store.musinsa.com/app/goods/%s?loc=goods_rank", pk);
					//log.info(url);
					
					Document doc  = Jsoup.parse(new URL(url),20000);
					//log.info(doc);
					
					File html = new File(dir, "detail.html");
					FileCopyUtils.copy(doc.toString().getBytes("utf-8"), html);
					
					String title = doc.selectFirst(".section_product_summary span.product_title").text();
					String brand = doc.selectFirst(".product_article .product_article_contents a").text();
					Integer price = new DecimalFormat("#,###원").parse(doc.selectFirst("#goods_price").text()).intValue();
				
					//log.info(title + "::" + brand + "::" + price );
					
					Elements lis = doc.select("#detail_thumb li:not(.video_thumb)");
					
					List<Map<String, Object>> list = new ArrayList();
					
//						lis.forEach(li-> {
//							String thumbLink = li.selectFirst("img").attr("src");
//							log.info(thumbLink);
//							String originLink = li.attr("id").equals("org_bigimg") ? thumbLink.replace("_60", "_960") : thumbLink.replace("_60", "_500") ;
//							log.info(originLink);
//						});
					
					for (int i=0; i < lis.size(); i++) {
						String thumbLink = lis.get(i).selectFirst("img").attr("src");
						
//							log.info(thumbLink);
						
						String originLink = lis.get(i).attr("id").equals("org_bigimg") ? thumbLink.replace("_60", "_960") : thumbLink.replace("_60", "_500") ;
//							log.info(originLink);
						
						thumbLink = "https:" + thumbLink;
						originLink = "https:" + originLink;
						//log.info(originLink);
						
						//  파일저장
						File origin = new File(file+"/"+pk,i+1+".jpg");
						FileCopyUtils.copy(FileCopyUtils.copyToByteArray(new URL(originLink).openStream()), origin);
						//섬네일
						File thum = new File(file+"/"+pk,"s_"+i+1+".jpg");
						FileCopyUtils.copy(FileCopyUtils.copyToByteArray(new URL(originLink).openStream()), thum);
						// map 입력
						Map<String, Object> map = new HashMap<>();
						map.put("bno", pk);
						map.put("ordered", i+1);
						list.add(map);
						
					}						
					System.out.println("=================================");
					GoodsVo vo = new GoodsVo();
					vo.setBno(Integer.parseInt(pk));
					vo.setTitle(title);
					vo.setBrand(brand);
					vo.setPrice(price);
					vo.setAttachs(list);
					//System.out.println("vo:" + vo);
					service.insert(vo);
					
				}
				catch (Exception e) {
					
				}		
				
			}  //end if

		});
		
		System.out.println("--------------- 완료 --------------");

				
		
		
	}
	
	@Test
	public void testFormat() throws ParseException {
		DecimalFormat df = new DecimalFormat("#,###원");
		Integer v = df.parse("299,999원").intValue();
		log.info(v);
	}
	
	
	
	
	 void saveHTML(int pageNum, String html) throws UnsupportedEncodingException, IOException {

		File file = new File(uploadFolder, pageNum + ".html");
		FileCopyUtils.copy(html.getBytes("utf-8"), file);
		
	}
	
	
	
	 void fileDownload(String pk, String link) throws MalformedURLException, IOException {		
		String uploladFolder = "c:/musinsa";
		File uploadPath = new File(uploladFolder,pk);
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		InputStream is = new URL(link).openStream();
		File file = new File(uploadPath, "thumb.jpg");
		FileCopyUtils.copy(FileCopyUtils.copyToByteArray(is), file);
	}
	 
	 

		@Test
		public void testCrawlDetailKream() throws MalformedURLException, IOException {

			File file = new File(uploadFolder);
			for (int i= 43990; i <=44000 ;i++){
				//log.info(dir.getName());


					try{
						String url = String.format("https://kream.co.kr/products/%d", i);
						//log.info(url);
						
						Document doc  = Jsoup.parse(new URL(url),20000);
						//log.info(doc);
						
						
						String brand = doc.selectFirst(".main_title_box a.brand").text();
						String name_en = doc.selectFirst(".main_title_box p.title").text();
						String name_ko = doc.selectFirst(".main_title_box p.sub_title").text();
						String img = doc.selectFirst(".product img").attr("src");
						String serialNo =  "";
						String ymd = "";
						String color = "";
						String price = ""; ;
						
						Elements detail = doc.selectFirst(".detail_product").children();
						
						  for (int j = 0; j < detail.size(); j++) {
							  if (j == 0 ) { serialNo = detail.get(j).selectFirst("dd.product_info").text(); }
							  if (j == 1 ) { ymd = detail.get(j).selectFirst("dd.product_info").text(); }
							  if (j == 2 ) { color = detail.get(j).selectFirst("dd.product_info").text(); }
//							  if (j == 3 ) { price = new DecimalFormat("#,###원").parse(detail.get(j).selectFirst("dd.product_info").text()).intValue(); }
							  if (j == 3 ) { price =detail.get(j).selectFirst("dd.product_info").text(); }
						  }
					
						System.out.println("brand:" + brand);
						System.out.println("name_en:" + name_en);
						System.out.println("name_ko:" + name_ko);
						System.out.println("img:" + img);
						System.out.println("serialNo:" + serialNo);
						System.out.println("ymd:" + ymd);
						System.out.println("color:" + color);
						System.out.println("price:" + price);
						
						System.out.println("=================================");
/*						GoodsVo vo = new GoodsVo();
						vo.setBno(Integer.parseInt(pk));
						vo.setTitle(title);
						vo.setBrand(brand);
						vo.setPrice(price);
						vo.setAttachs(list);
						//System.out.println("vo:" + vo);
						service.insert(vo);*/
						
					}
					catch (Exception e) {
						
					}		
					


			};
			
			System.out.println("--------------- 완료 --------------");

					
			
			
		}
		
}
