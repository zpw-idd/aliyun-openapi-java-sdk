package com.aliyuncs.http;

public class HttpResponse extends HttpMessage {

    private int status;

    public HttpResponse(String strUrl) {
        super(strUrl);
    }

    public HttpResponse() {
    }

    @Override
    public void setHttpContent(byte[] content, String encoding, FormatType format) {
        this.httpContent = content;
        this.encoding = encoding;
        this.httpContentType = format;
    }

    @Override
    public String getHeaderValue(String name) {
        String value = this.headers.get(name);
        if (null == value) {
            value = this.headers.get(name.toLowerCase());
        }
        return value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        if (200 <= this.status && this.status < 300) {
            return true;
        }
        return false;
    }
}
