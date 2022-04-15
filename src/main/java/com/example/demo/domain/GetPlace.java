package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter // getter를 자동 생성
@Setter // setter를 자동 생성
@ToString // toString을 자동 생성
public class GetPlace {
    private Integer userCodeNo;
    private String nickname;
    private Integer tripPlaceNo;
    private String tripPlaceCode;
    private String tripPlaceName;
    private String tripPlaceAdd0;
    private String tripPlaceAdd1;
    private String tripPlaceAdd2;
    private String tripPlaceAdd3;
    private String tripPlaceText;
    private String areaNo;
    private Integer worldFlag;
    private Float starRating;
    private Integer likeCount;
    private List<GetCategory> categoryList;
    private String tripPlaceLatitude;
    private String tripPlaceLongitude;
    private List<GetPlaceImg> placeImgList;
    private List<GetPlaceBImg> placeBImgList;
    private String insertTs;
    private String updateTs;
}
