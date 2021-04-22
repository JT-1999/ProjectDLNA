package com.example.projectdlna;

import java.io.Serializable;

/**
 * @author : J-T
 * date   : 2021/4/22
 * desc   :
 */
public class ResponModel<T> implements Serializable {
    public static final int RESULT_SUCCESS = 0;

    private T data;
    private int errorCode;
    private String errorMsg;
}
