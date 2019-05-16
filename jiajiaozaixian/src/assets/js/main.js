// JavaScript Document



var sw=$(window).width();
var sh=$(window).height();
$("a").focus(this.blur());

$(function(){
    $(window).scroll(function(){
		var st=$(window).scrollTop();
		if(st>32){
		$(".head").css("top","0px")
		}
		else
		$(".head").css("top","32px")
	})
})


//document.getElementById('fancydiv').scrollIntoView();

$(function(){
if(!placeholderSupport()){   // 判断浏览器是否支持 placeholder
    $('[placeholder]').focus(function() {
        var input = $(this);
        if (input.val() == input.attr('placeholder')) {
            input.val('');
            input.removeClass('placeholder');
        }
    }).blur(function() {
        var input = $(this);
        if (input.val() == '' || input.val() == input.attr('placeholder')) {
            input.addClass('placeholder');
            input.val(input.attr('placeholder'));
        }
    }).blur();
};
})
function placeholderSupport() {
    return 'placeholder' in document.createElement('input');
}