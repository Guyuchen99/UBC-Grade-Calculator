package persistence;

import org.json.JSONObject;

/**
 * Represents any data that can be saved to a file
 */

public interface Writable {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
