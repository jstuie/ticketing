
(function ($) {
    "use strict";


    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('#login').on('click',function(event){
        event.preventDefault();
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        // $("#login").prop("disabled", true);
        //
        // alert('1');
        if(check){

            var email = $('#email').val();
            var pass = $('#pass').val();


//             var data = new FormData();
//             data.append("username",email);
//             data.append("password",pass);
//             data.append("grant_type","password");
//
// //            alert(JSON.stringify(data));
//             for(var item of data.entries()) {
//                 alert(item [0]+ ', '+ item [1]); // key, value를 각각 출력
//             }

            var queryString = "username=admin&password=1&grant_type=password";

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/v1/admin/oauth/token",
                data : queryString,
                async: false,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader ("Authorization", "Basic "+btoa("kkalssam-admin:kkalssam-admin"));
                },
                success: function (data) {
                //    eventPlayerKey = data;
                    alert(JSON.stringify(data));
                    sessionStorage.setItem('access_token', data.access_token);
                    window.location.href = "view/dashboard.html";
                }


            });

        }else{

            return;
        }

    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim() == '') {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);