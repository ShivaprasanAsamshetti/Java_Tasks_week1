package Task8;

public class Filedata {

    private String fileName;
    private String fileType;
    private Double fileSizeInMb;
    private String content;
    private String uploadedBy;

    public Filedata(String fileName, String fileType,
                    Double fileSizeInMb,
                    String content,
                    String uploadedBy) {

        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSizeInMb = fileSizeInMb;
        this.content = content;
        this.uploadedBy = uploadedBy;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public Double getFileSizeInMb() {
        return fileSizeInMb;
    }

    public String getContent() {
        return content;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

}
