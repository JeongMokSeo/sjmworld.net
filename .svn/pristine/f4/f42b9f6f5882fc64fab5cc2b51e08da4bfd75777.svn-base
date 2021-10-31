package net.sjmworld.task;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.sjmworld.controller.UploadController;
import net.sjmworld.domain.AttachVo;
import net.sjmworld.mapper.AttachMapper;

@Log4j
@Component
@AllArgsConstructor
public class FileCheckTask {

	private AttachMapper attachMapper;
	
	private Set<String> getFolderBefore(List<AttachVo> fileList) {
		//Set<String> ret = new HashSet<>();
		return new HashSet<>(fileList.stream().map(vo -> vo.getPath()).collect(Collectors.toList()));
	
	}
	
	@Scheduled(cron= "0 0 2 * * *")
	public void checkFiles() {
		log.warn("file check task run ........................");
//		log.warn("= 1 ===========================================");
		
		//attachMapper.getOldFiles().forEach(log::info);
		
		List<AttachVo> fileList = attachMapper.getOldFiles();

		if (fileList == null) return;
				
		List<Path> fileListPaths=  
				fileList
				.stream()
				.map(vo ->
					Paths.get(UploadController.getUploadFolder(), vo.getFullPath()))
				.collect(Collectors.toList());
//		log.warn("= 2 ===========================================");
		fileListPaths.forEach(log::info);
		
		fileList
		.stream()
		.filter(vo->vo.isImage())
		.map(vo -> Paths.get(UploadController.getUploadFolder(),vo.getThumb()))
		.forEach(fileListPaths::add);
		
//		log.warn("= 3 ===========================================");
		fileListPaths.forEach(log::info);
		
//		log.warn("= 4 ===========================================");
		getFolderBefore(fileList).forEach(log::info);
		
		
		getFolderBefore(fileList).forEach(folder -> {
			File targetDir = Paths.get(UploadController.getUploadFolder(), folder).toFile();
//			log.warn("= 5 ===========================================");
//			log.warn(targetDir);
			
			File[] removeFiles = targetDir.listFiles(file -> !fileListPaths.contains(file.toPath()));
			Arrays.asList(removeFiles).forEach(file -> file.delete());
			
			//1줄로 했을때..
			//Arrays.asList(Paths.get(UploadController.getUploadFolder(), folder).toFile().listFiles(file -> !fileListPaths.contains(file.toPath()))).forEach(file -> file.delete());			
		});
		
	}
	
	
}
