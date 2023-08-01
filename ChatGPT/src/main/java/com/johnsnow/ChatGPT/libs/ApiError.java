package com.johnsnow.ChatGPT.libs;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(
        builder = ApiError.ApiErrorBuilder.class
)
public class ApiError {
    private String code;
    private String message;
    private String language;

    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiError)) {
            return false;
        } else {
            ApiError other = (ApiError)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$language = this.getLanguage();
                Object other$language = other.getLanguage();
                if (this$language == null) {
                    if (other$language != null) {
                        return false;
                    }
                } else if (!this$language.equals(other$language)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ApiError;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $language = this.getLanguage();
        result = result * 59 + ($language == null ? 43 : $language.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getCode();
        return "ApiError(code=" + var10000 + ", message=" + this.getMessage() + ", language=" + this.getLanguage() + ")";
    }

    public ApiError() {
    }

    public ApiError(final String code, final String message, final String language) {
        this.code = code;
        this.message = message;
        this.language = language;
    }

    @JsonPOJOBuilder(
            withPrefix = "",
            buildMethodName = "build"
    )
    public static class ApiErrorBuilder {
        private String code;
        private String message;
        private String language;

        ApiErrorBuilder() {
        }

        public ApiErrorBuilder code(final String code) {
            this.code = code;
            return this;
        }

        public ApiErrorBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder language(final String language) {
            this.language = language;
            return this;
        }

        public ApiError build() {
            return new ApiError(this.code, this.message, this.language);
        }

        public String toString() {
            return "ApiError.ApiErrorBuilder(code=" + this.code + ", message=" + this.message + ", language=" + this.language + ")";
        }
    }
}
