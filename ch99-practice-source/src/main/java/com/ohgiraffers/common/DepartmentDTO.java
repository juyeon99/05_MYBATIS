package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentDTO {
    private String deptId;
    private String deptTitle;
    private String locationId;
}
