package kopo.poly;

import kopo.poly.dto.StudentDTO;
import kopo.poly.service.IOcrService;
import kopo.poly.service.INlpService;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class SpringAiBasicApplication implements CommandLineRunner {

    private final IOcrService ocrService;
    private final INlpService nlpService;
    private final IStudentService studentService; // 추가

    public static void main(String[] args) {
        SpringApplication.run(SpringAiBasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("스프핑 부트 프로그램 시작!");

        /* -------------------------------------------------------------
        ClassPathResource resource = new ClassPathResource("image/sample01.png");
        String filePath = resource.getFile().getAbsolutePath();

        OcrDTO pDTO = new OcrDTO();
        pDTO.setFilePath(filePath);

        OcrDTO rDTO = ocrService.getOcrForImage(pDTO);
        String ocrResult = rDTO.getResult();

        log.info("▶ 이미지 글자 추출 성공!");

        NlpDTO nNlpDTO = new NlpDTO();
        nNlpDTO.setText(ocrResult);

        NlpDTO rNlpDTO = nlpService.getNouns(nNlpDTO);
        List<String> nouns = rNlpDTO.getNouns();
        ------------------------------------------------------------- */



        log.info("학생 등록 실습 시작!");

        StudentDTO pDTO = new StudentDTO();
        pDTO.setUserId("20260001");
        pDTO.setUserName("홍길동");
        pDTO.setEmail("gildong@kopo.ac.kr");
        pDTO.setAddr("서울시 강서구");

        studentService.insertStudent(pDTO);

        List<StudentDTO> rList = studentService.getStudentList();

        for (StudentDTO dto : rList) {
            log.info("학번 : " + dto.getUserId());
            log.info("이름 : " + dto.getUserName());
            log.info("이메일 : " + dto.getEmail());
            log.info("주소 : " + dto.getAddr());
        }

        log.info("학생 등록 실습 종료!");
    }
}