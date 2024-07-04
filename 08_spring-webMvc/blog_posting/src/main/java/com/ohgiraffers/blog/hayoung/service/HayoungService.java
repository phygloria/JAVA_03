package com.ohgiraffers.blog.hayoung.service;


import com.ohgiraffers.blog.hayoung.model.dto.BlogDTO;
import com.ohgiraffers.blog.hayoung.model.entity.HayoungBlog;
import com.ohgiraffers.blog.hayoung.repository.HayoungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Service
public class HayoungService {

private final HayoungRepository hayoungRepository;

    @Autowired
    public HayoungService(HayoungRepository hayoungRepository){
        this.hayoungRepository = hayoungRepository;
    }


    public int post(BlogDTO blogDTO) {
        List<HayoungBlog> hayoungBlogs = hayoungRepository.findAll();

        for (HayoungBlog blog: hayoungBlogs){
            if(blog.getBlogTitle().equals(blogDTO.getBlogTitle())){
                return 0;
            }
        }

        HayoungBlog saveBlog = new HayoungBlog();
        saveBlog.setBlogContent(blogDTO.getBlogContent());
        saveBlog.setBlogTitle(blogDTO.getBlogTitle());
        saveBlog.setCreateDate(new Date());
        HayoungBlog result  = hayoungRepository.save(saveBlog);

        int resultValue = 0;

        if(result != null){
            resultValue = 1;
        }

        return resultValue;
    }

}
