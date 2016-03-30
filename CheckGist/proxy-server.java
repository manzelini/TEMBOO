import com.temboo.core.*;
import com.temboo.Library.GitHub.GistsAPI.Gists.CheckGist;
import com.temboo.Library.GitHub.GistsAPI.Gists.CheckGist.CheckGistInputSet;

// Instantiate the session
TembooSession session = new TembooSession("accountName", "myFirstApp", "abc123xxxxxxxxxxxxxx");

// Act as a proxy on behalf of the JavaScript SDK
TembooProxy tembooProxy = new TembooProxy();

// Instantiate the Choreo
CheckGist checkGistChoreo = new CheckGist(session);

// Add Choreo proxy with an ID matching that specified by the JS SDK client
tembooProxy.addChoreo("jsCheckGist", checkGistChoreo);

// Get an input object for the Choreo
CheckGistInputSet checkGistInputs = checkGistChoreo.newInputSet();

// Set credential to use for execution
checkGistInputs.setCredential("GitHubAccount");

tembooProxy.setDefaultInputs("jsCheckGist", checkGistInputs);

// Whitelist client inputs
tembooProxy.allowUserInputs("jsCheckGist", "ID");

// Execute the requested Choreo. httpPostData contains the contents of the JavaScript client POST
// request. How this variable is populated will depend on your Java web server implementation
String result = tembooProxy.execute(httpPostData.get("temboo_proxy"), true);