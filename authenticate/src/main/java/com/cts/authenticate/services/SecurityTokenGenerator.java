/**
 * 
 */
package com.cts.authenticate.services;

import java.util.Map;

import com.cts.authenticate.model.User;

/**
 * @author ubuntu
 *
 */
public interface SecurityTokenGenerator {

	public Map<String, String> generateToken(User user);
}
