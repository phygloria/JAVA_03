package com.ohgiraffers.blog.hayoung.repository;

import com.ohgiraffers.blog.hayoung.model.entity.HayoungBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HayoungRepository extends JpaRepository<HayoungBlog, Integer> {

}
