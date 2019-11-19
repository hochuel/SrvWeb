<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.min.css'/>">
    <script src="<c:url value='/resources/js/external/jquery/jquery.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
    <script src="<c:url value='/resources/js/srv.js'/>"></script>
    <style>

    </style>
    <title>Srv Web </title>

    <script>
    $(document).ready(function(){


        $( "#dialog" ).dialog({
        	autoOpen: false,
            show: {
                effect: "blind",
                duration: 1000
            },
            hide: {
                effect: "explode",
                duration: 1000
            },
        	buttons: [
        		{
        			text: "Send",
        			click: function() {
        			    var url = "/sendMessage.do";
        			    var data = $.sendFormData(url, $("#vForm"));
        			    alert(data.msg);

        				$( this ).dialog( "close" );
        			}
        		},
        		{
        			text: "Cancel",
        			click: function() {
        				$( this ).dialog( "close" );
        			}
        		}
        	]
        });

        $( "#dialog-link" ).click(function( event ) {
        	$( "#dialog" ).dialog( "open" );
        	//event.preventDefault();
        });
     });
    </script>
</head>
<body>


    <button id="dialog-link" class="ui-button ui-corner-all ui-widget">
        <span class="ui-icon ui-icon-newwin"></span>Send Message
    </button>



    <div id="dialog" title="Send Message">
        <div>
            <form name="vForm" id="vForm" method="post">
              <table>
                  <tbody>
                      <tr>
                          <td>TOKEN</td>
                          <td><input id="token" name="token" value="fX5GayZTbGE:APA91bFfi1MNjyqBrh8X0YpxUdQxcXgiYr9SvAbAM8iIydU8uBXqAw_PWcj_YJHaCwiTt3g8EWEU4Sz8WX42joRw6csGhq2nSbxdZUrw5-kF1ePRVMeRCJpsL_omTNwfRts6K7J8oOym"></td>
                      </tr>
                      <tr>
                          <td>TITLE</td>
                          <td><input id="title" name="title"></td>
                      </tr>
                      <tr>
                          <td>BODY</td>
                          <td>
                            <textarea id="contents" name="contents"></textarea>
                          </td>
                      </tr>
                  </tbody>
              </table>
            </form>
         </div>
    </div>

</body>
</html>