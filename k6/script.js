import { check } from 'k6';
import http from 'k6/http';

export const options = {
    stages: [
		{ duration: '30s', target: 1 },
        { duration: '5m',  target: 200 },
        { duration: '5m',  target: 200 },
        { duration: '1m',  target: 0 },
    ],
};

export default function () {
    const res = http.get('https://hello.apps.zimakov.net/pi/7');
    check(res, {
        'is status 200': (r) => r.status === 200,
    });
}
