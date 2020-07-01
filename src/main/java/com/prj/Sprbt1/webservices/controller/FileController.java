package com.prj.Sprbt1.webservices.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.prj.Sprbt1.webservices.entity.FileDTO;
import com.prj.Sprbt1.webservices.repository.FileRepository;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = {"*"})
@CrossOrigin(origins =
//"*"
{ "http://localhost:1001" }
//,
//allowedHeaders = "Content-Type"
//methods = RequestMethod.GET, allowedHeaders = "Authorization"
)
public class FileController {

	@Autowired
	FileRepository fileRepository;

	@GetMapping("/files")
	public List<FileDTO> getAll() {
		//System.out.println("List: ");
		return fileRepository.findAll();
	}


	@PostMapping("/files/create")
	public ResponseEntity<FileDTO> createFile(@RequestBody FileDTO fileDTO) { // , UriComponentsBuilder builder) {
		System.out.println("Time: " + new Timestamp(System.currentTimeMillis()).toLocaleString());
		fileDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()).toLocaleString());
		fileDTO.setModifiedDate(new Timestamp(System.currentTimeMillis()).toLocaleString());
		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(builder.path("/files/{id}").buildAndExpand(fileDTO.getId()).toUri());
		try {
			fileRepository.save(fileDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Create: " + HttpStatus.CREATED);
		return new ResponseEntity<FileDTO>(headers, HttpStatus.CREATED);
		// return fileRepository.save(fileDTO);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<FileDTO> getFileById(@PathVariable("id") Long id) {
		FileDTO fileDTO = new FileDTO();
		fileDTO = fileRepository.findById(id).orElse(null);
		return new ResponseEntity<FileDTO>(fileDTO, HttpStatus.OK);

	}

	@PutMapping("/files/{id}")
	public ResponseEntity<FileDTO> updateArticle(@RequestBody FileDTO fileDTO, @PathVariable("id") Long id) {
		// fileDTO.setId(fileDTO.getId());
		FileDTO fileDTO1 = fileRepository.findById(id).orElse(null);
		fileDTO1.setFname(fileDTO.getFname());
		fileDTO1.setFpname(fileDTO.getFpname());
		fileDTO1.setFpdesc(fileDTO.getFpdesc());
		fileDTO1.setModifiedDate(new Timestamp(System.currentTimeMillis()).toLocaleString());
		fileRepository.save(fileDTO1);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<FileDTO>(headers, HttpStatus.OK);
	}
}
