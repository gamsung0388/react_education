package com.example.boardTest.File;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:3030")
public class FileController {
	
	private final FileService fileService;
	
	@PostMapping("/file/upload")    
    Map<String, Object> insertBoard(@RequestPart(value="file", required=false) MultipartFile[] files) {
    	Map<String,Object> result = new HashMap<>();
    	    	
    	result.put("result", "FAIL");
    	
		String FileNames ="";
		System.out.println("paramMap =>"+files[0]);
		String _filePath = "C:/dev/gamDawn/";
		
		//파일 시퀀스 리스트
		List<String> fileIds = new ArrayList<String>();
		
		for (MultipartFile mf : files) {
			   
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            String extension = originFileName.substring(originFileName.lastIndexOf(".")); // 파일 확장자
            String safeFile =System.currentTimeMillis() + originFileName; // 저장할 파일명
                        
            try {
            	File f1 = new File(_filePath+safeFile);
//                mf.transferTo(f1);
                
                result.put("origNm", originFileName);
                result.put("pyscNm", safeFile);
                result.put("pyscPath", _filePath);
                result.put("thumbnailNm", safeFile);
				result.put("fileExt", extension);
				result.put("fileSize", mf.getSize());
				result.put("contentType", mf.getContentType());
				
				fileService.insertFile(result);
				
				InputStream fileStream = mf.getInputStream();
				byte[] fileBytes = IOUtils.toByteArray(fileStream); // read input stream into a byte array
                FileUtils.copyInputStreamToFile(new ByteArrayInputStream(fileBytes), f1); //파일 저장

				//배열에 담기
				fileIds.add(String.valueOf(result.get("fileId")));			
								
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
		result.put("fileIdxs", fileIds.toString());
		result.put("result", "OK");
				
        return result;
    }
}
