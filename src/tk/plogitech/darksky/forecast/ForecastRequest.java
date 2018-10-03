/*
 * The MIT License
 *
 * Copyright 2017 Philipp-André Plogmann.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tk.plogitech.darksky.forecast;

import java.net.URL;
import java.util.Objects;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;

/**
 * Represents a single Request to the DarkSky API.
 *
 * Construct the Request object using the builder.
 *
 * @author Puls
 */
public class ForecastRequest {

    private final Timeouts timeouts;
    private final URL url;

    /**
     * @param url The URL which contains the parameters to request the weather forecast.
     * @param timeouts The timeouts used for the request.
     */
    ForecastRequest(URL url, Timeouts timeouts) {
	notNull("URL cannot be null.", url);
	notNull("Timeouts cannot be null.", timeouts);

	this.url = url;
	this.timeouts = timeouts;
    }

    /**
     * @return The URL which contains the parameters to request the weather forecast.
     */
    public URL url() {
	return url;
    }

    /**
     * @return The timeouts that are used when connecting and reading from the DarkSky API.
     */
    public Timeouts timeouts() {
	return timeouts;
    }

    @Override
    public String toString() {
	return "ForecastRequest{" + "url=" + url + '}';
    }

    @Override
    public int hashCode() {
	int hash = 5;
	hash = 73 * hash + Objects.hashCode(this.timeouts);
	hash = 73 * hash + Objects.hashCode(this.url);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final ForecastRequest other = (ForecastRequest) obj;
	if (this.timeouts != other.timeouts()) {
	    return false;
	}
	return Objects.equals(this.url, other.url);
    }

}
