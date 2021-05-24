var main = {
    init : function(){
        var_this = this;
        $('#btn-save').on('click',function(){
            _this.save();
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
            contentType :


        })
    }
}