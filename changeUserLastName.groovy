import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import java.util.List;
import com.liferay.portal.kernel.model.User;

try {
  userCount= UserLocalServiceUtil.getUsersCount();
  usersList = UserLocalServiceUtil.getUsers(0, userCount);

  for(user in usersList) {
    if(user.getFirstName() == "Rodolfo") {
      user.setLastName("Alves");
      UserLocalServiceUtil.updateUser(user);
      out.println("""<div class="portlet-msg-success">User updated successfully!</div>""");
    }
  }

out.println("""
  <div class="bg-white px-4 pt-3">
    <div class="row" style="border-bottom: 1px solid #d0d0d0">
      <div class="col-2 p-2" style="border-right: 1px solid #d0d0d0">ID</div>
      <div class="col-10 p-2">Name</div>
    </div>
  </div>
""");

  for(user in usersList) {
      out.println("""
        <div class="bg-white px-4">
          <div class="row" style="border-bottom: 1px solid #d0d0d0">
            <div class="col-2 p-2" style="border-right: 1px solid #d0d0d0">${user.getUserId()}</div>
            <div class="col-10 p-2">${user.getFullName()}</div>
          </div>
        </div>
      """);
  }

} catch(e) {
    out.println("""
      <div class="portlet-msg-error">
          <p>Oops! Something went wrong.</p>
          ${e}
      </div>
    """);
    e.printStackTrace(out);
}