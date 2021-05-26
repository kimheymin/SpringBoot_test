var main = {
    init : function(){
        var_this = this;

        $('#btn-save').on('click',function(){
            _this.save();
        });

         $('#btn-update').on('click',function(){
            _this.update();
         });
    },

    save : function(){
        var data = {
            title : $('#title').val();
            author : $('#author').val();
            content : $('#content').val();
        };

        $.ajax({
            type: 'POST',
            url : '/api/v1/posts',
            dateType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('글 등록 완료!');
            window.application.href='/'
        }),fail(function (error){
           alert(JSON.stringify(error));
        });
    },

    update : function(){
        var data = {
            title : $('#title').val();
            content : $('#content').val();
        };

        var id = $('#id').val();

        $.ajax({
                type: 'PUT',
                url : '/api/v1/posts'+id,
                dateType : 'json',
                contentType : 'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function(){
                alert('글 수정 완료!');
                window.application.href='/'
            }),fail(function (error){
               alert(JSON.stringify(error));
            });
        }
};

main.init();