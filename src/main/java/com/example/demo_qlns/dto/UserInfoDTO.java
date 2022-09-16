package com.example.demo_qlns.dto;

import java.util.Date;

public interface UserInfoDTO {
    public Long getId();
    public String getEmail();
    public String getTel();
    public String getUsername();
    public String getRoleName();
    public String getDepartmentName();
    public String getLocationName();
    public String getLevelJapanName();
    public Date getStartDate();
    public Date getEndDate();
}
