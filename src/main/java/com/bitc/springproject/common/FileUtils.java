package com.bitc.springproject.common;


import com.bitc.springproject.dto.GameFileDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {
    public List<GameFileDto> parseFileInfo(int gameIdx, MultipartHttpServletRequest uploadFiles) throws Exception {
        if(ObjectUtils.isEmpty(uploadFiles)) return null;

        List<GameFileDto> fileList = new ArrayList<>();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();

        String path1 = "src/main/resources/static/img/" + current.format(format);
        String path2 = "/img/" + current.format(format);

        File file = new File(path1);
        if(!file.exists()) file.mkdirs();


        Iterator<String> iterator = uploadFiles.getFileNames();

        String newFileName;
        String originalFileExtension;
        String contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = uploadFiles.getFiles(iterator.next());

            for (MultipartFile multipartFile : list) {
                if (!multipartFile.isEmpty()) {
                    contentType = multipartFile.getContentType();

                    if (ObjectUtils.isEmpty(contentType)) break;
                    else {
                        if(contentType.contains("image/jpeg")) originalFileExtension = ".jpg";
                        else if(contentType.contains("image/png")) originalFileExtension = ".png";
                        else if(contentType.contains("image/gif")) originalFileExtension = ".gif";
                        else break;
                    }

                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

                    GameFileDto gameFile = new GameFileDto();
                    gameFile.setGameIdx(gameIdx);
                    gameFile.setFileSize(multipartFile.getSize());
                    gameFile.setOriginalFileName(multipartFile.getOriginalFilename());
                    gameFile.setStoredFilePath(path2 + "/" + newFileName);

                    fileList.add(gameFile);

                    file = new File(path1 + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }

        return fileList;
    }
}
