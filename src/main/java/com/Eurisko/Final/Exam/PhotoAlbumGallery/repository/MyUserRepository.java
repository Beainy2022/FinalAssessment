package com.Eurisko.Final.Exam.PhotoAlbumGallery.repository;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MyUserRepository extends MongoRepository<MyUser,Long > {

}
