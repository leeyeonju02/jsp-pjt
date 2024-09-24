<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<html>
  <head>
    <meta charset="UTF-8" />
    <title>AdminLTE 2 | Join</title>
    <meta
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
      name="viewport"
    />
    <!-- Bootstrap 3.3.4 -->
    <link
      href="/resources/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <!-- Font Awesome Icons -->
    <link
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <!-- Theme style -->
    <link
      href="/resources/dist/css/AdminLTE.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <!-- iCheck -->
    <link
      href="/resources/plugins/iCheck/square/blue.css"
      rel="stylesheet"
      type="text/css"
    />
  </head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="#"><b>KDT-MULTICAMPUS</b></a>
      </div>
      <!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>

        <form
          action="/user/join.multicampus"
          method="post"
          enctype="multipart/form-data"
        >
          <div class="form-group has-feedback">
            <input
              type="text"
              name="id"
              class="form-control"
              placeholder="USER ID"
            />
            <span
              class="glyphicon glyphicon-envelope form-control-feedback"
            ></span>
            ${errMap.id}
          </div>
          <div class="form-group has-feedback">
            <input
              type="password"
              name="pwd"
              class="form-control"
              placeholder="Password"
            />
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            ${errMap.pwd}
          </div>
          <div class="form-group has-feedback">
            <input
              type="text"
              name="name"
              class="form-control"
              placeholder="Name"
            />
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            ${errMap.name}
          </div>
          <!-- img upload -->
          <div class="form-group has-feedback">
            <input
              type="file"
              name="file"
              class="form-control"
              placeholder="Image upload"
            />
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            ${errMap.name}
          </div>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox" name="useCookie" /> Remember Me
                </label>
              </div>
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">
                Sign In
              </button>
            </div>
            <!-- /.col -->
          </div>
        </form>

        <a href="#">I forgot my password</a><br />
        <a href="/user/" class="text-center">Register a new membership</a>
      </div>
      <!-- /.login-box-body -->
    </div>
    <!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script
      src="/resources/bootstrap/js/bootstrap.min.js"
      type="text/javascript"
    ></script>
    <!-- iCheck -->
    <script
      src="/resources/plugins/iCheck/icheck.min.js"
      type="text/javascript"
    ></script>
    <script>
      $(function () {
        $("input").iCheck({
          checkboxClass: "icheckbox_square-blue",
          radioClass: "iradio_square-blue",
          increaseArea: "20%", // optional
        });
      });
    </script>
  </body>
</html>

해당 항목을 즐겨찾기로 바꾸기반응 사용자 지정 새 항목 4-수업정보방-공지용에
메시지 보내기 Shift + Return 키를 눌러 새 행을 추가합니다 프로필 의 프로필 사진
연락처 정보 이메일 주소 jslim9413@gmail.com 생산성을 높이고 싶으신가요? 사이드바
구성 내게 리마인더 보내기 오디오 및 비디오 클립 공유 모바일 아이콘 이동 중에도
[25회차] 채용연계 풀스택 개발자 부트캠프(스프링&리액트)에 대한 연결을 유지하세요
