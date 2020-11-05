package com.fucct.findstuff.article;

import com.fucct.findstuff.common.ImageUrl;

public class ArticleFixture {
    public static final String TITLE = "Hello World";
    public static final String OTHER_TITLE = "안녕 세상";
    public static final String CONTENT = "Hello. My name is DD.";
    public static final String OTHER_CONTENT = "안녕하세요. 제 이름은 디디입니다.";
    public static final ImageUrl IMAGE_URL = ImageUrl.of("http://www.naver.com");
    public static final ImageUrl OTHER_IMAGE_URL = ImageUrl.of("http://www.baemin.com");

    public static Article createWithoutId() {
        return Article.builder()
            .title(TITLE)
            .content(CONTENT)
            .build();
    }

    public static Article createOtherWithoutId() {
        return Article.builder()
            .title(OTHER_TITLE)
            .content(OTHER_CONTENT)
            .build();
    }
}
