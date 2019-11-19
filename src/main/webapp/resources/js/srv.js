$(document).ready(function(){

    $.fn.serializeObject = function() {
        var obj = null;
        try {
            // this[0].tagName이 form tag일 경우
            if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) {
                var arr = this.serializeArray();
                if(arr){
                    obj = {};
                    jQuery.each(arr, function() {
                            // obj의 key값은 arr의 name, obj의 value는 value값
                        obj[this.name] = this.value;
                    });
                }
            }
        }catch(e) {
            alert(e.message);
        }finally{

        }
        return obj;
    };

    $.sendPost=function(url, objForm){
        var result = "";

        $.ajax({
            async: false,
            contentType : "application/json",
            type: "post",
            url: url,
            data: $(objForm).serialize(),
            dataType: "json",
            success: function(data, status, xhr) {
                result = data;
            }
        });

        return result;
    };


    $.sendFormData=function(url, vForm){
        var result = "";

        $.ajax({
            async: false,
            contentType : "application/json;charset=UTF-8",
            type: "post",
            url: url,
            data : JSON.stringify(vForm.serializeObject()),
            dataType: "json",
            success: function(data, status, xhr) {
                result = data;
            }
        });

        return result;
    }

    $.sendData=function(url, jsonData){
        var result = "";
        $.ajax({
            async: false,
            contentType : "application/json",
            type: "post",
            url: url,
            data : JSON.stringify(jsonData),
            dataType: "json",
            success: function(data, status, xhr) {
                result = data;
            }
        });

        return result;
    }


    $.ajaxSetup({
        cache : false,
        beforeSend: function(xhr){
            xhr.setRequestHeader("AJAX", true);
        },
        error: function(xhr, status, error){
            if (xhr.status == 400) {
                //로그인 정보 없음 처리부..
            }else{
                if(xhr.status != 0){//같은 url이 아닐경우 나는 오류 localhost, 127.0.0.1 테스트시 발생
                    alert("ajaxSetup error ::" + JSON.stringify(error));
                    console.log("status :" + status);
                    console.log("xhr:" + xhr.status);
                    console.log("error:" + error);
                }
            }
        }

    });
});
