/**
 *
 */
package org.gwtopenmaps.openlayers.client.feature;

import org.gwtopenmaps.openlayers.client.Style;
import org.gwtopenmaps.openlayers.client.StyleMap;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * 
 *         Class name deviates intentionally from OpenLayers class name. Both
 *         vector layers and vector features are called Vector in OpenLayers.
 * 
 * 
 */
public class VectorFeature extends Feature {

    protected VectorFeature(JSObject vectorFeature) {
	super(vectorFeature);
    }

    public VectorFeature(Geometry g) {
	super(VectorFeatureImpl.create(g.getJSObject()));
    }

    public VectorFeature(Geometry g, Style s) {
	super(VectorFeatureImpl.create(g.getJSObject(), s.getJSObject()));
    }

    public static VectorFeature narrowToVectorFeature(JSObject vectorFeature) {
	return (vectorFeature == null) ? null
		: new VectorFeature(vectorFeature);
    }

    /**
     * Provided together with getGeometry method, so geometry subclass can be
     * instantiated from geometry, for example: Point p =
     * Point.narrowToPoint(vf.getGeometry) Where vf is a VectorFeature of which
     * the geometry is determined by user input, for example by drawing a
     * feature.
     */
    public String getGeometryClassName() {
	return VectorFeatureImpl.getGeometryClassName(getJSObject());
    }

    public JSObject getGeometry() {
	return VectorFeatureImpl.getGeometry(getJSObject());
    }

    /**
     * Set the attributes. This object (attributes) holds arbitrary properties
     * that describe the feature.
     * <p>
     * Note: the attributes are only applied for styles defined inside a
     * {@link StyleMap}. If just using a single style for the
     * {@link VectorOptions} the attributes will be ignored.
     * 
     * @param vectorFeatureAttributes
     *            The attributes to set
     */
    public void setAttributes(VectorFeatureAttributes vectorFeatureAttributes) {
	VectorFeatureImpl.setAttributes(this.getJSObject(),
		vectorFeatureAttributes.getJSObject());

    }

    // TODO provide getAttributes method
    // if a VectorFeature has attributes, you want to access them...

}
