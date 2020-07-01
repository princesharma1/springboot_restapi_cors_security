package com.prj.Sprbt1.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.Sprbt1.webservices.entity.FileDTO;

public interface FileRepository extends JpaRepository<FileDTO, Long> {


}
