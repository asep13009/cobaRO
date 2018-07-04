
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
         hideValidate(this);
     });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
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


//buat nambah aspek
counter=0;
function actionAspek(){
  counterNext=counter+1;
  document.getElementById("input"+counter).innerHTML = "<p>Aspek <input name='aspek[]' type='text' placeholder='Nama Aspek' />  <a href='javascript:actionSubaspek();'> <span class='glyphicon glyphicon-plus' aria-hidden='false'></span> Subaspek</a>  &nbsp; &nbsp <a href='javascript:hapus(div);'> <span class='glyphicon glyphicon-remove' aria-hidden='true'></span> Hapus </a> </p><div id=\"input"+counterNext+"\"></div>  ";
  counter++;
}
//buat nambah subaspek

function actionSubaspek(){
  counterNext=counter+1;
  document.getElementById("input"+counter).innerHTML = "<p>&nbsp;&nbsp;&nbsp;&nbsp;Subaspek <input name='subaspek[]' type='text' placeholder='Nama Subaspek' /><input name='nilaisubaspek[]' type='text' placeholder='Nilai Subaspek' /><a href='javascript:hapus(div);'> <span class='glyphicon glyphicon-remove' aria-hidden='true'></span> Hapus </a>  </p><div id=\"input"+counterNext+"\"></div> ";

  counter++;


}

function hapus(cur){
  element.remove();
}