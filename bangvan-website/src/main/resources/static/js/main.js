document.addEventListener("DOMContentLoaded", function () {
  showNotification();
});

function showNotification() {
  var notification = document.getElementById("message-notification");
  notification.classList.add("show-notification");
  setTimeout(function () {
    hideNotification();
  }, 5000);
}

function hideNotification() {
  var notification = document.getElementById("message-notification");
  notification.classList.remove("show-notification");
}
