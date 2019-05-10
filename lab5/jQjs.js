$(document).ready(function(){
    $("#desktop1").click(function(){
        $("#desktop1").slideDown("slow");
        $("#desktop4").slideDown("slow", function () {
            $("#desktop1").slideDown("slow");
            $("#desktop1").hide();
        });
    });
    $("#desktop2").click(function(){
        $("#desktop2").slideDown("slow");
        $("#desktop1").slideDown("slow", function () {
            $("#desktop2").slideDown("slow");
            $("#desktop2").hide();
        });
    });

    $("#desktop3").click(function() {
        $("#desktop3").slideDown("slow");
        $("#desktop2").slideDown("slow", function () {
            $("#desktop3").slideDown("slow");
            $("#desktop3").hide();
        });
    });

    $("#desktop4").click(function(){
        $("#desktop4").slideDown("slow");
        $("#desktop3").slideDown("slow", function() {
            $("#desktop4").slideDown("slow");
            $("#desktop4").hide();
        });
    });
});