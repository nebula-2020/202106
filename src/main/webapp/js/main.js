function getUrlAttr(k) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == k) { return pair[1]; }
    }
    return (false);
}
function ajax(params) {
    var type, url, data, success, error;
    type = params.type;
    url = params.url;
    data = params.data;
    success = params.success;
    error = params.error;
    var request = new XMLHttpRequest();
    request.open(type, url);
    request.onreadystatechange = function () {
        if (request.status == 200 && request.readyState == 4) {
            try {
                success(request.responseText, request.status);
            } catch (error) {
                console.log(error)
            }
        } else {
            try {
                error(request.responseText, request.status);
            } catch (error) {
                console.log(error)
            }
        }
    }
    request.send(data);
}