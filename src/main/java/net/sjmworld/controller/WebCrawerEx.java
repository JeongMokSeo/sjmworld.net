package net.sjmworld.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.FileCopyUtils;

public class WebCrawerEx {
	public static void main(String[] args) throws MalformedURLException, IOException {
		// Parsing : 검수번역
		// XML Parsing ex) $.parseXML()
		// HTML Parsing
		
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
	
	//제품정보 가져오기
	
	static void saveHTML(int pageNum, String html) throws UnsupportedEncodingException, IOException {
		String uploadFolder = "c:/musinsa";
		File file = new File(uploadFolder, pageNum + ".html");
		FileCopyUtils.copy(html.getBytes("utf-8"), file);
		
	}
	
	
	
	static void fileDownload(String pk, String link) throws MalformedURLException, IOException {		
		String uploladFolder = "c:/musinsa";
		File uploadPath = new File(uploladFolder,pk);
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		InputStream is = new URL(link).openStream();
		File file = new File(uploadPath, "thumb.jpg");
		FileCopyUtils.copy(FileCopyUtils.copyToByteArray(is), file);
	}
	
}
