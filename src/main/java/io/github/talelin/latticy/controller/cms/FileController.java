package io.github.talelin.latticy.controller.cms;

import io.github.talelin.latticy.bo.FileBO;
import io.github.talelin.latticy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 */
@RestController
@RequestMapping("/cms/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param multipartHttpServletRequest 携带文件的 request
     * @return 文件信息
     */
    @PostMapping
//    @LoginRequired
    public List<FileBO> upload(MultipartHttpServletRequest multipartHttpServletRequest) throws InterruptedException {
        MultiValueMap<String, MultipartFile> fileMap =
                multipartHttpServletRequest.getMultiFileMap();
        return fileService.upload(fileMap);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        try {
            fileService.deleteImg(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @DeleteMapping("/byName/{name}")
    public void deleteByName(@PathVariable  String name){
        fileService.deleteImgByName(name);
    }
}
