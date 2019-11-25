package me.musclegeeker.sell.common.result;

public class Response {

    public static final Integer OK = 0;

    private static final String OK_MESSAGE = "OK";

    /**
     * 成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> ResultVO OK() {
        ResultVO result = new ResultVO();
        result.setCode(OK);
        result.setSuccess(Boolean.TRUE);
        result.setMessage(OK_MESSAGE);

        return result;
    }

    /**
     * 成功响应
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVO OK(T t) {
        ResultVO result = new ResultVO();
        result.setCode(OK);
        result.setSuccess(Boolean.TRUE);
        result.setMessage(OK_MESSAGE);
        result.setData(t);
        return result;
    }

    /**
     * 异常响应
     *
     * @param errorCode
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultVO ERROR(int errorCode, String message) {
        ResultVO result = new ResultVO();
        result.setCode(errorCode);
        result.setSuccess(Boolean.FALSE);
        result.setMessage(message);
        return result;
    }
}
