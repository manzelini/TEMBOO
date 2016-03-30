import com.temboo.core.*;
import com.temboo.Library.GitHub.GistsAPI.Gists.ListGistsByUser;
import com.temboo.Library.GitHub.GistsAPI.Gists.ListGistsByUser.ListGistsByUserInputSet;

// Instantiate the session
TembooSession session = new TembooSession("accountName", "myFirstApp", "abc123xxxxxxxxxxxxxx");

// Act as a proxy on behalf of the JavaScript SDK
TembooProxy tembooProxy = new TembooProxy();

// Instantiate the Choreo
ListGistsByUser listGistsByUserChoreo = new ListGistsByUser(session);

// Add Choreo proxy with an ID matching that specified by the JS SDK client
tembooProxy.addChoreo("jsListGistsByUser", listGistsByUserChoreo);

// Get an input object for the Choreo
ListGistsByUserInputSet listGistsByUserInputs = listGistsByUserChoreo.newInputSet();

// Set credential to use for execution
listGistsByUserInputs.setCredential("GitHubOnTEMBOO");

tembooProxy.setDefaultInputs("jsListGistsByUser", listGistsByUserInputs);

// Execute the requested Choreo. httpPostData contains the contents of the JavaScript client POST
// request. How this variable is populated will depend on your Java web server implementation
String result = tembooProxy.execute(httpPostData.get("temboo_proxy"), true);