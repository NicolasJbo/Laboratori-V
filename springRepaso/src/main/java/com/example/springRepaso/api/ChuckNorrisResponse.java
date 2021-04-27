package com.example.springRepaso.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class ChuckNorrisResponse {

    @SerializedName("categories")
    private HashMap<Integer,String> categories;
    @SerializedName("created_at")
    private String created;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("id")
    private String id;
    @SerializedName("updated_at")
    private  String updated;
    @SerializedName("url")
    private String url;
    @SerializedName("value")
    private String value;

}
