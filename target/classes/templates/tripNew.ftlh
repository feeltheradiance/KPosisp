<#import "parts/common.ftlh" as c>
<@c.page>
    <div>
        <form method="post">
            <h3>Форма поездки</h3>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="row mb-2">
                <label class="col-sm-2 col-form-label">From</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="fromCity">
                </div>
            </div>
            <div class="row mb-2">
                <label class="col-sm-2 col-form-label">To</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="toCity">
                </div>
            </div>
            <div class="row mb-2">
                <label class="col-sm-2 col-form-label">Date</label>
                <div class="col-sm-2">
                    <input type="date" class="form-control" name="date">
                </div>
            </div>
            <div class="row mb-2">
                <label class="col-sm-2 col-form-label">Seats</label>
                <div class="col-sm-2">
                    <input type="number" class="form-control" name="seats">
                </div>
            </div>
            <div class="row mb-2">
                <label class="col-sm-2 col-form-label">Комментарий</label>
                <div class="col-sm-2">
                    <textarea class="form-control" name="comment"></textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Создать</button>
        </form>
    </div>
</@c.page>
