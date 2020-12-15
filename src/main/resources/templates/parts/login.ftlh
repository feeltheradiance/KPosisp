<#macro login path>
    <form action="${path}" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="row mb-3">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Username</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" name="username">
        </div>
    </div>
    <div class="row mb-3">
        <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-3">
          <input type="password" class="form-control" name="password">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post" class="d-flex">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-outline-success" type="submit">SignOut</button>
    </form>
</#macro>