package kopo.poly.service.impl;

import kopo.poly.dto.StudentDTO;
import kopo.poly.mapper.IStudentMapper;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService implements IStudentService {

    private final IStudentMapper studentMapper;

    @Override
    public void insertStudent(StudentDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + ".insertStudent Start!");


        StudentDTO rDTO = studentMapper.getStudent(pDTO);


        Optional<StudentDTO> res = Optional.ofNullable(rDTO);

        if (res.isPresent()) {
            log.info("이미 가입된 회원입니다.");
        } else {
            studentMapper.insertStudent(pDTO);
            log.info("학생 등록 성공!");
        }

        log.info(this.getClass().getName() + ".insertStudent End!");
    }

    @Override
    public List<StudentDTO> getStudentList() throws Exception {
        log.info(this.getClass().getName() + ".getStudentList Start!");
        return studentMapper.getStudentList();
    }
}