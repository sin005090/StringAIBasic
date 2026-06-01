package kopo.poly.service.impl;

// 아래 import 문들이 없어서 빨간 줄이 뜨는 것입니다.
import kopo.poly.dto.OcrDTO;
import kopo.poly.service.IOcrService;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.File;

@Slf4j
@Service
public class OcrService implements IOcrService {
    @Override
    public OcrDTO getReadforImageText(OcrDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + ".getReadforImageText Start!!");

        // OCR 분석 대상 이미지 파일 경로 설정
        ClassPathResource resource = new ClassPathResource(pDTO.getFilePath() + "/" + pDTO.getFileName());

        ITesseract instance = new Tesseract();

        // Tesseract 설치 경로 설정 (데이터 폴더)
        instance.setDatapath(IOcrService.modelFile);

        // 인식할 언어 설정 (한국어: kor, 영어: eng)
        instance.setLanguage("kor");

        // 이미지 파일로부터 텍스트 읽기
        String result = instance.doOCR(resource.getFile());

        // 결과값을 DTO에 담아서 반환
        OcrDTO rDTO = new OcrDTO();
        rDTO.setResult(result);

        log.info(this.getClass().getName() + ".getReadforImageText End!!");

        return rDTO;


    }
}