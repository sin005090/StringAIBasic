package kopo.poly.service;

import kopo.poly.dto.StudentDTO;
import java.util.List;

public interface IStudentService {


    void insertStudent(StudentDTO pDTO) throws Exception;


    List<StudentDTO> getStudentList() throws Exception;
}