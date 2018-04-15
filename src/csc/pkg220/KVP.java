package csc.pkg220;

/**
 * K is the type of the keys, V is the type of the values.
 * @author graham
 */
public class KVP< K, V>
{
	public K key;
	public V value;

	public KVP(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString()
	{
		return "KVP{" + "key=" + key + ", value=" + value + '}';
	}
}