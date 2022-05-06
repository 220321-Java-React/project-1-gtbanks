package com.revature.backend.dtos;

public class UpdateStatusDTO {
    public UpdateStatusDTO(Integer updatedStatusId) {
        this.updatedStatusId = updatedStatusId;
    }

    public Integer getUpdatedStatusId() {
        return updatedStatusId;
    }

    public void setUpdatedStatusId(Integer updatedStatusId) {
        this.updatedStatusId = updatedStatusId;
    }

    private Integer updatedStatusId;

}
