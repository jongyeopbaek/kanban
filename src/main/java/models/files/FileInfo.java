package models.files;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileInfo {
    private long id;
    private String gid;
    private String location;
    private String fileName;
    private String extension;
    private String fileType;
    private LocalDateTime regDt;

}