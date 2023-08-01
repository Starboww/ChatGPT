package com.johnsnow.ChatGPT.libs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    T data;
    ApiResult result;
    ApiError error;

    public T getData() {
        return this.data;
    }

    public ApiResult getResult() {
        return this.result;
    }

    public ApiError getError() {
        return this.error;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setResult(final ApiResult result) {
        this.result = result;
    }

    public void setError(final ApiError error) {
        this.error = error;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResponse)) {
            return false;
        } else {
            ApiResponse<?> other = (ApiResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if (this$data == null) {
                        if (other$data == null) {
                            break label47;
                        }
                    } else if (this$data.equals(other$data)) {
                        break label47;
                    }

                    return false;
                }

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                Object this$error = this.getError();
                Object other$error = other.getError();
                if (this$error == null) {
                    if (other$error != null) {
                        return false;
                    }
                } else if (!this$error.equals(other$error)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ApiResponse;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        Object $error = this.getError();
        result = result * 59 + ($error == null ? 43 : $error.hashCode());
        return result;
    }

    public ApiResponse() {
    }

    public ApiResponse(final T data, final ApiResult result, final ApiError error) {
        this.data = data;
        this.result = result;
        this.error = error;
    }

    public String toString() {
        Object var10000 = this.getData();
        return "ApiResponse(data=" + var10000 + ", result=" + this.getResult() + ", error=" + this.getError() + ")";
    }
}
