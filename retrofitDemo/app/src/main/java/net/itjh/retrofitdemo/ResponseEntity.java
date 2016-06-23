package net.itjh.retrofitdemo;

import java.io.Serializable;

public class ResponseEntity {


  private String message;
  private int StatusCode;
  private String content;
  private String request; //请求路径


  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public int getStatusCode() {
    return StatusCode;
  }

  public void setStatusCode(int statusCode) {
    StatusCode = statusCode;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ResponseEntity() {
  }

  public ResponseEntity(String message, int statusCode, String content, String request) {
    this.message = message;
    StatusCode = statusCode;
    this.content = content;
    this.request = request;
  }

  @Override
  public String toString() {
    return "ResponseEntity{" +
            "message='" + message + '\'' +
            ", StatusCode=" + StatusCode +
            ", content=" + content +
            ", request='" + request + '\'' +
            '}';
  }

}