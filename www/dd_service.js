window.DDS = {};
window.DDS.echo = function(str, callback) {

        cordova.exec(callback, function(err) {
        	console.log("cordova.exec error "+err);
            callback('Nothing to echo.');
        }, "DDService", "echo", [str]);
    };
    