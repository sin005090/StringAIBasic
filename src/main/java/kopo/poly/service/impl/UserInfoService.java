package kopo.poly.service.impl;

import kopo.poly.service.IOcrService;

public class OcrService implements IOcrService {

    @value("${ocr.model,data}")
    private String ocrModel;
}