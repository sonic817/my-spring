package demo.controller;

import demo.service.TestService;
import demo.service.DBException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Api(tags = "TestController", description = "테스트 컨트롤러")
public class TestController {

    @Autowired
    TestService testService;

    //region
    @GetMapping("/")
    @ResponseBody
    public JSONObject home(
            @ApiIgnore HttpSession session, HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        JSONObject jSONOResponse = new JSONObject();

        jSONOResponse.put("result", "true");
        jSONOResponse.put("message", "hello world");

        return jSONOResponse;
    }
    //endregion


    //region
    @GetMapping("/excel")
    @ApiOperation(value = "excel 파일을 읽어서, db에 저장하는 기능", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "token", value = "접속중인 userCodeNo의 token을 넣어주세요.", required = false, dataType = "String", paramType = "header"),
//    })
    @ResponseBody
    public JSONObject get(
            @ApiIgnore HttpSession session, HttpServletRequest request, HttpServletResponse response,
            @RequestParam("path") String path
    ) throws Exception {
        JSONObject jSONOResponse = new JSONObject();

        boolean isSuccess = testService.inExcel(path);

        jSONOResponse.put("message", isSuccess);
        return jSONOResponse;
    }
    //endregion


    //region
    @GetMapping("/img")
    @ApiOperation(value = "이미지 url을 받아서 s3에 업로드하는 기능", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "token", value = "접속중인 userCodeNo의 token을 넣어주세요.", required = false, dataType = "String", paramType = "header"),
//    })
    @ResponseBody
    public JSONObject setImg(
            @ApiIgnore HttpSession session, HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        JSONObject jSONOResponse = new JSONObject();

        jSONOResponse = testService.setImg();

        return jSONOResponse;
    }
    //endregion


    //region
    @GetMapping("/tran")
    @ApiOperation(value = "롤백 테스트", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "token", value = "접속중인 userCodeNo의 token을 넣어주세요.", required = false, dataType = "String", paramType = "header"),
//    })
    @ResponseBody
    public JSONObject tran(
            @ApiIgnore HttpSession session, HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        JSONObject jSONOResponse = new JSONObject();

        try {
            jSONOResponse = testService.tran();
        } catch (DBException e) {
            e.printStackTrace();
            jSONOResponse = e.getValue();
        }

        return jSONOResponse;
    }
    //endregion
}