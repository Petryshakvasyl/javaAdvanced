package ua.lviv.lgs.springjpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MediaResponce {

    private String fileName;

    private String url;
}
