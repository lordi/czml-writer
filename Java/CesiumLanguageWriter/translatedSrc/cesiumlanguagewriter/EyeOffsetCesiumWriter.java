package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;

/**
 *  
 Writes a <code>EyeOffset</code> to a  {@link CesiumOutputStream}.  A <code>EyeOffset</code> defines an offset in eye coordinates which can optionally vary over time.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis poitns up, and the Z-axis points into the screen.
 

 */
public class EyeOffsetCesiumWriter extends CesiumInterpolatablePropertyWriter<EyeOffsetCesiumWriter> {
	/**
	 *  
	The name of the <code>cartesian</code> property.
	

	 */
	public static final String CartesianPropertyName = "cartesian";
	private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public EyeOffsetCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected EyeOffsetCesiumWriter(EyeOffsetCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
						return createCartesianAdaptor();
					}
				}, false);
	}

	@Override
	public EyeOffsetCesiumWriter clone() {
		return new EyeOffsetCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the eye offset specified as a Cartesian `[X, Y, Z]` position in eye coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	

	 * @param value The value.
	 */
	public final void writeCartesian(Cartesian value) {
		String PropertyName = CartesianPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian3(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the eye offset specified as a Cartesian `[X, Y, Z]` position in eye coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
		writeCartesian(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the eye offset specified as a Cartesian `[X, Y, Z]` position in eye coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		String PropertyName = CartesianPropertyName;
		openIntervalIfNecessary();
		CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumInterpolatableValuePropertyWriter} to write a value in <code>Cartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumInterpolatableValuePropertyWriter<Cartesian> asCartesian() {
		return m_asCartesian.getValue();
	}

	final private ICesiumInterpolatableValuePropertyWriter<Cartesian> createCartesianAdaptor() {
		return new CesiumInterpolatableWriterAdaptor<EyeOffsetCesiumWriter, Cartesian>(this, new CesiumWriterAdaptorWriteCallback<EyeOffsetCesiumWriter, Cartesian>() {
			public void invoke(EyeOffsetCesiumWriter me, Cartesian value) {
				me.writeCartesian(value);
			}
		}, new CesiumWriterAdaptorWriteSamplesCallback<EyeOffsetCesiumWriter, Cartesian>() {
			public void invoke(EyeOffsetCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
				me.writeCartesian(dates, values, startIndex, length);
			}
		});
	}
}